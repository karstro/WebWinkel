# WebWinkel
docker run -e POSTGRES_PASSWORD=3141 -d -h postgres -p 5432:5432 postgres
./mvnw.cmd flyway:migrate
./mvnw.cmd spring-boot:run -D"spring-boot.run.jvmArguments"="--add-opens=java.base/java.lang=ALL-UNNAMED"
docker exec -it 72aebb2cc97b psql -d postgres -U postgres -W 3141