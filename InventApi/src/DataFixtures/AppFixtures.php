<?php

namespace App\DataFixtures;

use Doctrine\Bundle\FixturesBundle\Fixture;
use Doctrine\Persistence\ObjectManager;
use App\Entity\Product;
use App\Entity\Bill;
use App\Entity\Purchase;

class AppFixtures extends Fixture
{
    public function load(ObjectManager $manager): void
    {
        for ($i = 0; $i < 5; $i++) {
            $product = new Product();
            $product->setName('product ' . $i);
            $product->setPrice(mt_rand(10, 100));
            $product->setCode(mt_rand(10, 100));
            $manager->persist($product);
            $purchase = new Purchase();
            $purchase->setBillID(1);
            $purchase->setProductID($i);
            $purchase->setProduct($product);
            $manager->persist($purchase);
        }

        for ($i = 5; $i < 10; $i++) {
            $product = new Product();
            $product->setName('product ' . $i);
            $product->setPrice(mt_rand(10, 100));
            $product->setCode(mt_rand(10, 100));
            $manager->persist($product);
            $purchase = new Purchase();
            $purchase->setBillID(2);
            $purchase->setProductID($i);
            $purchase->setProduct($product);
            $manager->persist($purchase);
        }

        for ($i = 0; $i < 5; $i++) {
            $bill = new Bill();
            $bill->setName('bill ' . $i);
            $bill->setAmount(mt_rand(10, 100));
            $bill->setUserID(1);
            $bill->setCreateDate(new \DateTime());

            $manager->persist($bill);
        }

        // for ($i = 0; $i < 5; $i++) {

        // }

        $manager->flush();
    }
}



