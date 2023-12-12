FROM php:8.0-apache

COPY src /var/www/html

RUN apt-get update && apt-get install -y curl

RUN a2enmod rewrite