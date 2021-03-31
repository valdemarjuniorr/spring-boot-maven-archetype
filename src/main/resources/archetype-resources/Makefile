# build the application without tests
build:
	mvn clean install -DskipTests

# Running tests in 4 threads
test:
	mvn -T 4 surefire:test

# execute build without tests and run the application with local-container profile
run: build
	java -jar target/${artifactId}-${version}.jar --spring.profiles.active=local

# create the container with postgres and localstack
compose-up:
	docker-compose -f docker-compose.local.yml up --build -d

# destroy the container with postgres and localstack
compose-down:
	docker-compose -f docker-compose.local.yml down

# start application with swagger
start: compose-up run
