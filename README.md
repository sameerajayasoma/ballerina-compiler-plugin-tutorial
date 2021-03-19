# Ballerina Compiler Plugin Sample - `checkpanic` usage analyzer
This repository contains a sample Ballerina compiler plugin that reports diagnostics for each usage of the `checkpanic` construct. 

Ballerina compiler plugins provides a mechanism that allows a user of Ballerina programming language to interact with the Ballerina compiler. Refer to this [slide deck](https://docs.google.com/presentation/d/1Yhp9nx2qYCM0mDAsg6gAbO8_STrvs1Ou1noG5_cFfW8/edit#slide=id.p) for more information on compiler plugins, how to user them and how to develop them. 

There are three top-level directories in this repository:
1) [checkpanic-usage-analyzer-javalib](checkpanic-usage-analyzer-javalib)
2) [checkpanic-usage-analyzer](checkpanic-usage-analyzer)
3) [myapp](myapp)

## [checkpanic-usage-analyzer-javalib](checkpanic-usage-analyzer-javalib)
This directory contains the compiler plugin implementation written in Java. Why did I implement a Ballerina compiler plugin in Java? Because the Ballerina compiler frontend is fully written in Java, hence most of the Ballerina compiler SDK APIs are also Java APIs. 

<img src="https://user-images.githubusercontent.com/2637328/111550241-f39df380-873a-11eb-899e-6688fee4d07a.jpg" alt="alt text" width="429" height="272">

## [checkpanic-usage-analyzer](checkpanic-usage-analyzer)
This directory contains the Ballerina package that distributes the compiler plugin. A compiler plugin should always be distributed as part of a Ballerina package. 

## [myapp](myapp)
This directory contains the Ballerina package that uses the compiler plugin. 
