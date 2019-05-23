# Fluid Logic

Execute business rules with script languages while interoperating with Java.

## When to use it

This is a good strategy to use when you're not sure about this approach or the rules technology platform (such as JBoss Drools), therefore postponing the architecture decision.

The obvious advantage of this technique is to update business rules without pushing your code forward. On rigid and slow enterprise infrastructures this design pattern might be very attractive. Not so much if you have a microservices approach with your team having control over your resources and applications.

Don't forget to implement tests for your scripts if you're going down this road.

## Java Script Engine

Originally I did implemnt it with Rhino engine, later replaced with Nashorn which is [due to be deprecated](https://openjdk.java.net/jeps/335).

When grooming this example for my public repo I've upgrated it to use GraalVM, which has a Nashorn compatibility mode that allows proprites from objects to be read in JavaScript without much effort.



