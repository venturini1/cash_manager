<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Routing\Annotation\Route;
use App\Repository\PurchaseRepository;
use App\Repository\ProductRepository;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Component\HttpFoundation\Request;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\Routing\Generator\UrlGeneratorInterface;
use App\Entity\Purchase;

class PurchaseController extends AbstractController
{
    // GET ALL METHOD
    #[Route('/api/purchases', name: 'app_purchase', methods: ['GET'])]
    public function getBookList(PurchaseRepository $purchaseRepository, SerializerInterface $serializer): JsonResponse
    {
        $purchaseList = $purchaseRepository->findAll();
        $jsonPurchaseList = $serializer->serialize($purchaseList, 'json');
        return new JsonResponse($jsonPurchaseList, Response::HTTP_OK, [], true);
    }

    // GET ONE MEHODE
    #[Route('/api/purchases/{id}', name: 'detailPurchase', methods: ['GET'])]
    public function getDetailPurchase(int $id, SerializerInterface $serializer, PurchaseRepository $purchaseRepository): JsonResponse
    {
        $purchase = $purchaseRepository->find($id);

        if ($purchase) {
            $jsonPurchase = $serializer->serialize($purchase, 'json');
            return new JsonResponse($jsonPurchase, Response::HTTP_OK, [], true);
        }

        return new JsonResponse(null, Response::HTTP_NOT_FOUND);
    }

    // GET ONE BY BILL ID
    #[Route('/api/purchases/bill/{billID}', name: 'PurchasesByBill', methods: ['GET'])]
    public function getPurchasesByUser(int $billID, SerializerInterface $serializer, PurchaseRepository $purchaseRepository): JsonResponse
    {
        $purchases = $purchaseRepository->findBy(['billID' => $billID]);

        $jsonPurchases = $serializer->serialize($purchases, 'json');

        return new JsonResponse($jsonPurchases, Response::HTTP_OK, [], true);
    }

    // POST METHOD
    #[Route('/api/purchases', name: 'createPurchase', methods: ['POST'])]
    public function createPurchase(Request $request, SerializerInterface $serializer, EntityManagerInterface $em, UrlGeneratorInterface $urlGenerator, ProductRepository $productRepository): JsonResponse
    {
        $purchase = $serializer->deserialize($request->getContent(), Purchase::class, 'json');
        $content = $request->toArray();
    
        $productId = $content['productID'] ?? -1;
        $purchase->setProduct($productRepository->find($productId));
    
        if (!$purchase->getProduct()) {
            return new JsonResponse(['error' => 'Product must be specified.'], Response::HTTP_BAD_REQUEST);
        }
    
        $em->persist($purchase);
        $em->flush();
    
        $jsonPurchase = $serializer->serialize($purchase, 'json', ['groups' => 'getPurchases']);
        $location = $urlGenerator->generate('detailPurchase', ['id' => $purchase->getId()], UrlGeneratorInterface::ABSOLUTE_URL);

        return new JsonResponse($jsonPurchase, Response::HTTP_CREATED, ["Location" => $location], true);
    }
}
