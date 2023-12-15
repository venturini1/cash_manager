<?php

use App\Kernel;
use Symfony\Component\Dotenv\Dotenv;
use Symfony\Component\HttpFoundation\Request;

require dirname(__DIR__).'/vendor/autoload.php';

// Charger les variables d'environnement
(new Dotenv())->loadEnv(dirname(__DIR__).'/.env');

// Configurer le mode d'environnement
$env = $_SERVER['APP_ENV'] ?? $_ENV['APP_ENV'] ?? 'dev';
$debug = $_SERVER['APP_DEBUG'] ?? $_ENV['APP_DEBUG'] ?? 'dev' !== $env;

// Vérifier l'environnement
// (les sections $trustedProxies et $trustedHosts sont omises pour traiter toutes les adresses IP et tous les noms d'hôtes comme faisant confiance)

// Créer une instance du kernel
$kernel = new Kernel($env, $debug);

// Créer une instance de la requête
$request = Request::createFromGlobals();

// Gérer la requête via le kernel
$response = $kernel->handle($request);

// Envoyer la réponse au client
$response->send();

// Terminer la gestion de la requête
$kernel->terminate($request, $response);
