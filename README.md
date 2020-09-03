# Leasing-app

Steps to run:
1. Execute commands on application dir:
* mvn clean install
* mvn spring-boot:run

---------------------

Two REST endpoints created

1. POST /leasing/v1/applyLease

which consumes car leasing application json and returns lease id, leasing decision status status and vehicle details.
Request example:

{
  "person": {
    "income": 500,
    "name": "string",
    "personID": "string"
  },
  "vehicle": {
    "licensePlate": "AAA666",
    "make": "Kia",
    "model": "Car",
    "vinNumber": "JSD4561SDSA"
  },
  "requestedAmount": 1500,
  "coApplicants": [
    {
      "income": 200,
      "name": "john",
      "personID": "123456"
    }
  ]
}

2. GET /leasing/v1/creditApplicationStatus/{id}

Which return credit application status by given id.
