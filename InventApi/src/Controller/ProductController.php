<?php

namespace App\Controller;

use App\Repository\ProductRepository;
use App\Entity\Product;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Generator\UrlGeneratorInterface;
use Symfony\Component\Serializer\Normalizer\AbstractNormalizer;

class ProductController extends AbstractController
{
    // GET ALL METHOD
    #[Route('/api/products', name: 'app_product', methods: ['GET'])]
    public function getBookList(ProductRepository $productRepository, SerializerInterface $serializer): JsonResponse
    {
        $productList = $productRepository->findAll();
        $jsonProductList = $serializer->serialize($productList, 'json');
        return new JsonResponse($jsonProductList, Response::HTTP_OK, [], true);
    }

    // GET ONE MEHODE
    #[Route('/api/products/code/{id}', name: 'detailProduct', methods: ['GET'])]
    public function getDetailProduct(int $id, SerializerInterface $serializer, ProductRepository $productRepository): JsonResponse
    {
        $product = $productRepository->find($id);

        if ($product) {
            $jsonProduct = $serializer->serialize($product, 'json');
            return new JsonResponse($jsonProduct, Response::HTTP_OK, [], true);
        }

        return new JsonResponse(null, Response::HTTP_NOT_FOUND);
    }

    // GET ONE BY CODE
    #[Route('/api/products/code/{code}', name: 'ProductsByCode', methods: ['GET'])]
    public function getBillsByUser(int $code, SerializerInterface $serializer, ProductRepository $productRepository): JsonResponse
    {
        $product = $productRepository->findBy(['code' => $code]);

        $jsonProduct = $serializer->serialize($product, 'json');

        return new JsonResponse($jsonProduct, Response::HTTP_OK, [], true);
    }

    // DELETE METHOD
    #[Route('/api/products/{id}', name: 'deleteProduct', methods: ['DELETE'])]
    public function deleteProduct(Product $product, EntityManagerInterface $em): JsonResponse
    {
        $em->remove($product);
        $em->flush();

        return new JsonResponse(null, Response::HTTP_NO_CONTENT);
    }

    // POST METHOD
    #[Route('/api/products', name: 'createProduct', methods: ['POST'])]
    public function createProduct(Request $request, SerializerInterface $serializer, EntityManagerInterface $em, UrlGeneratorInterface $urlGenerator): JsonResponse
    {
        $product = $serializer->deserialize($request->getContent(), Product::class, 'json');
        $em->persist($product);
        $em->flush();

        $jsonProduct = $serializer->serialize($product, 'json', ['groups' => 'getProducts']);

        $location = $urlGenerator->generate('detailProduct', ['id' => $product->getId()], UrlGeneratorInterface::ABSOLUTE_URL);

        return new JsonResponse($jsonProduct, Response::HTTP_CREATED, ["Location" => $location], true);
    }

    // PUT METHOD
    #[Route('/api/products/{id}', name: 'updateProduct', methods: ['PUT'])]
    public function updateProduct(Request $request, SerializerInterface $serializer, Product $currentProduct, EntityManagerInterface $em): JsonResponse
    {
        $updatedProduct = $serializer->deserialize(
            $request->getContent(),
            Product::class,
            'json',
            [AbstractNormalizer::OBJECT_TO_POPULATE => $currentProduct]
        );

        $em->persist($updatedProduct);
        $em->flush();

        return new JsonResponse(null, JsonResponse::HTTP_NO_CONTENT);
    }
}