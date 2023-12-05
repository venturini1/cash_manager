FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# # Utilisation d'une image de base avec Maven pour la construction
# FROM maven:3.8.3-openjdk-17 AS build

# # Copie des fichiers du code source
# COPY src /usr/src/app/src
# COPY pom.xml /usr/src/app

# # Changement du répertoire de travail
# WORKDIR /usr/src/app

# # Construction de l'application avec Maven
# RUN mvn clean install -DskipTests  # Ajout de l option pour sauter l exécution des tests pendant la construction

# # Utilisation d'une image de base plus légère avec Java pour l'exécution
# FROM eclipse-temurin:17-jdk-alpine

# # Changement du répertoire de travail
# WORKDIR /app

# # Copie du fichier JAR de l'étape précédente vers le conteneur
# COPY target/*.jar app.jar

# # Exposition du port sur lequel l'application Spring Boot fonctionne
# EXPOSE 8080

# # Commande pour exécuter l'application au démarrage du conteneur
# CMD ["java", "-jar", "app.jar"]
