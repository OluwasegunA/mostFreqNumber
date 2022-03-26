# mostFreqNumber
## A Vertx REST API Algorithm to check a sentence for the most occuring words. Print the word and its frequency


## How to run Project
1. Insatll Maven
1. Run `mvn clean compile`
1. Run `mvn clean package`
1. Run ` java -jar target/interview-1.0-SNAPSHOT-fat.jar`
1. Make a sample curl request to ```curl --location --request POST 'localhost:8080/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "sentence": "sentence sentence sentence sentence"
}'```
