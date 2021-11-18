# Using Mutation Testing to Improve Quality of Unit Tests 
Code kata: using mutation testing to improve quality of unit tests.

### Summary
This is a set of exercises that will demonstrate 
* That having passing unit tests and high unit test coverage numbers may be giving a false sense of security due to low quality of the tests
* how to identify problem spots using mutation testing and common test smells
* how to fix these problems 

### What Is a Code Kata?
A code kata is an exercise in programming which helps programmers hone their skills through practice. A code kata is usually set up as a series of unit tests, which fail. Your task is to write code to make them pass. The idea is inspired by the Japanese concept of kata in the martial arts. Just like in the martial arts, you can repeat a kata multiple times to make improvements to your solutions. 
 
Please note that this kata is a little different - all the tests initially pass. Don't worry, all the same ideas mentioned above still apply here. We will improve the tests, in the process making them fail, and then we will fix the code to make the tests pass, but by then they will be good tests. 

### Running This Kata
To build this kata you will need
* Java 8 or newer
* Maven 3.6.1 or newer
* an IDE of your choice

There are two modules in this project 
* **kata** - contains the exercises, including the domain and test classes described below. You should be working with this module.    
* **kata_code_smell** - another kata with only one function (and a lot of smells) 

1.  **Run all the unit tests in the `mtk.domain.CompanyTest` class.** They should all pass. Check the test coverage metrics using either maven output or a coverage reporting function in your IDE test runner. The coverage should be close to 100%. Good news: there are tests, they all pass, and they cover all of our business logic. Looks like the software is ready to ship!

    Unfortunately that would be a terrible idea as the code is full of bugs. To prove it, just take a look at the `mtk.CompanyRunner` class, which contains some simple business logic in its `main()` method. Run `mtk.CompanyRunner.main()` and looks at the console output. Does it look right? How can we have all these bugs despite having all these test?

2.  **Run the unit tests with mutations**. Mutations will be introduced in your code by PIT - a mutation testing tool .
    1. **Enable the `pitest` maven profile** for the project. This profile is bound to `test` phase of the maven lifecycle.
    2. **Run the `test` task** in the module `kata`. 
    (To run it from the command line with the profile activated, execute the `mvn test -P pitest` command.) With the profile enabled, this task will invoke the PIT framework to first introduce changes in the application code and then execute tests.
    4. **Inspect the results**. The results are written in HTML format into a file in the `target/pit-reports/YYYYMMDDHHMI` directory. Open this file in a browser - you should see quite a bit of red. This means that some of the code mutations managed to survive - were not caught by the unit tests. Which means that in fact our unit tests do not test what they are supposed to.

3.  **Find enough tests to be robust.** 


5.   **Kill all mutants!** The tests that have been fixed this way should catch mutation introduced by PIT. When all the tests (and the logic under test) are fixed, no mutations should be able to survive. So the end state should be passing tests and dead mutants (and no smells).

### Unit Test Best Practices
These are some of the practices to follow to ensure that the unit tests are effective, easy to maintain, easy to execute:
* Automated - require no human involvement to determine the outcome
* Focused - each test method tests one scenario
* Complete - test the edge cases, try to cover all meaningfully different scenarios
* Well named - test method name describes the scenario being tested
* Fast - the relevant tests execute in a few seconds or faster  
* Independent - no external dependencies, no dependencies on other tests
* Test the behavior, not the implementation

### Unit Test Smells
These are the signs that there is possibly something wrong with the test - either because the test itself is not well written, or the code under test is not test friendly (which probably means that this code is not well factored):
* No assertions
* Irrelevant assertions
* Use of Mocks
* Expected results are calculated rather than explicitly specified
* Test code reuse (that is test logic reuse, test utilities are good)
* Test data reuse
* "Flickering" tests(tests with nondeterministic behavior)
* Interdependencies between tests (e.g., execution order)
* Long running tests
* `@Ingore`'d or commented out tests

These smells often come together. For example, sharing test data can lead to tests' success depending on the execution order.

### Unit Test Quality
How can we measure the quality of the unit tests in a system? One metric, which is used broadly, is **test coverage**. Some things to keep in mind:
* Test coverage
    * %-ge of LOC, methods, classes covered by tests
    * Does not guarantee the covered code is actually tested
    * Does identify the code that is definitely not tested
* So having a coverage target in not entirely pointless, but...
* ...don't optimize just for coverage
* How do we make sure that the tests actually test? Mutation Testing is one way to ensure relevance of unit tests.

### Mutation Testing
Mutation testing is a way to validate the quality of unit tests. It means introducing changes in the code and observing the behavior of the unit tests. Assuming that all the tests were passing before the mutation, some of the unit tests will either start failing (good) or all the tests will keep on passing (bad). The latter scenario means that the unit tests do not really validate outcomes of the code under test: the results for all intents and purposes become random, yet all the tests pass.   

### Test Driven Development
Adopting Test Driven Development (TDD) will result in better tests, better interfaces, less unnecessary code, and more confident and steady development process. Just follow these steps:

* Write a test
    * Take the user's perspective: "What is the API that would make my job the easiest?"
    * Think small increments
* Make the test pass
    * Do whatever it takes: Duplication? Fine! Hardcoding the expected result? Fine!
* Refactor
    * Remove duplication
* Repeat for all meaningfully different scenarios
* Reap the benefits
    * Almost all code is tested
    * You know when to stop coding
    * User friendly interfaces
    * Well factored code
    * Just enough abstraction
    * Just enough code
    * Develop with confidence!

Sounds too good to be true? The secret is that TDD does require a lot of discipline from its practitioners to work in tiny increments, diligently following the steps above, and not cutting corners. _Without the discipline_ it is likely you will end up with tests (and code under tests) of the usual "quality".

### Useful Links
* [JUnit](http://junit.org)
* [PITest](http://pitest.org)
