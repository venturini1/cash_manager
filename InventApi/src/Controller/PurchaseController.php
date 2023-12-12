<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Routing\Annotation\Route;
use App\Repository\PurchaseRepository;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Serializer\SerializerInterface;

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

    // GET ONE BY BILL ID
    #[Route('/api/purchases/{billID}', name: 'PurchasesByUser', methods: ['GET'])]
    public function getPurchasesByUser(int $billID, SerializerInterface $serializer, PurchaseRepository $purchaseRepository): JsonResponse
    {
        $purchases = $purchaseRepository->findBy(['billID' => $billID]);

        $jsonPurchases = $serializer->serialize($purchases, 'json');

        return new JsonResponse($jsonPurchases, Response::HTTP_OK, [], true);
    }
}
