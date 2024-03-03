# Zero to Implementation in 50 Minutes, No Kidding!

The purpose of this presentation is to show how a user can utilize elements of Internal Developer Platforms (IDP) to add new features when developing their applications.  
Each project in this repository adds a new feature to the application that is required for it to get to a production environment.

* demo-function - provides the sample project from which you can build a simple Spring Cloud Function app that can process orders. The basic `Order` function will accept an `Order` instance and return a `OrderConfirmation` instance.  Also includes readme instructions on its build and usage.
* demo-function-web - adds the dependencies that provides the ability for a user to post a JSON `Order` and receive a JSON formatted `OrderConfirmation`.  It also includes readme instructions on its build and usage.
* Demo-function-kafka-send - adds the dependencies that provides the ability for a user to create an app that receives an `Order` message from a topic and then transform it to a `OrderConfirmation` then send the `OrderConfirmation` to another topic.  