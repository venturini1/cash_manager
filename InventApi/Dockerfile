# Utiliser une image PHP avec Composer préinstallé
FROM php:8.2-fpm-buster

# Installer les dépendances nécessaires
RUN apt-get update --fix-missing \
    && apt-get install -y \
        libzip-dev \
        unzip \
        git \
    && docker-php-ext-install zip pdo_mysql

# Installer Composer
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

# Installer Symfony globalement
RUN curl -sS https://get.symfony.com/cli/installer | bash \
    && mv /root/.symfony*/bin/symfony /usr/local/bin/symfony

# Définir le répertoire de travail dans le conteneur
WORKDIR /var/www/html

# Copier les fichiers de l'application Symfony dans le conteneur
COPY . .

# Installer les dépendances de l'application Symfony
RUN composer install --no-scripts --no-interaction

# Nettoyer le cache APT
RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# Supprimer un script spécifique qui peut causer des problèmes
RUN rm -f /etc/apt/apt.conf.d/docker-clean

# Exposer le port 8000 pour le serveur Symfony
EXPOSE 8000

# Commande par défaut pour démarrer le serveur Symfony
CMD ["symfony", "server:start", "--allow-http", "--no-tls"]
