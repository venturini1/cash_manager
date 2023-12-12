<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Serializer\SerializerInterface;
use App\Repository\BillRepository;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\Routing\Generator\UrlGeneratorInterface;
use App\Entity\Bill;

class BillController extends AbstractController
{
    // GET ALL
    #[Route('/api/bills', name: 'app_bill', methods: ['GET'])]
    public function getBookList(BillRepository $billRepository, SerializerInterface $serializer): JsonResponse
    {
        $billList = $billRepository->findAll();
        $jsonBillList = $serializer->serialize($billList, 'json');
        return new JsonResponse($jsonBillList, Response::HTTP_OK, [], true);
    }

    // GET ONE MEHODE
    #[Route('/api/bills/{id}', name: 'detailBill', methods: ['GET'])]
    public function getDetailBill(int $id, SerializerInterface $serializer, BillRepository $billRepository): JsonResponse
    {
        $bill = $billRepository->find($id);

        if ($bill) {
            $jsonBill = $serializer->serialize($bill, 'json');
            return new JsonResponse($jsonBill, Response::HTTP_OK, [], true);
        }

        return new JsonResponse(null, Response::HTTP_NOT_FOUND);
    }

    // GET ONE BY USER ID
    #[Route('/api/bills/user/{userID}', name: 'BillbyUserID', methods: ['GET'])]
    public function getBillsByUser(int $userID, SerializerInterface $serializer, BillRepository $billRepository): JsonResponse
    {
        $bills = $billRepository->findBy(['userID' => $userID]);

        $jsonBills = $serializer->serialize($bills, 'json');

        return new JsonResponse($jsonBills, Response::HTTP_OK, [], true);
    }

    // CREATE BILL
    #[Route('/api/bills', name: 'createBill', methods: ['POST'])]
    public function createBill(Request $request, SerializerInterface $serializer, EntityManagerInterface $em, UrlGeneratorInterface $urlGenerator): JsonResponse
    {
        $bill = $serializer->deserialize($request->getContent(), Bill::class, 'json');
        $em->persist($bill);
        $em->flush();

        $jsonBill = $serializer->serialize($bill, 'json', ['groups' => 'getBills']);

        $location = $urlGenerator->generate('detailBill', ['id' => $bill->getId()], UrlGeneratorInterface::ABSOLUTE_URL);

        return new JsonResponse($jsonBill, Response::HTTP_CREATED, ["Location" => $location], true);
    }
}
