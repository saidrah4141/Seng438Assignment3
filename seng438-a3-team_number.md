**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \#: 2     |     |
| -------------- | --- |
| Student Names: |     |
|      Qasim Amar          |     |
|      Said Rahmani          |     |
|             Ahmed Addullah
|    Muhammad Bilal |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction
For this lab we were assigned to get familiar with testing coverage tools, were we used EclEmma. By using different techniques in this lab to decide which test cases must be developed, compared to previous assignments we used white-box testing in order to improve coverage for previously developed test cases. Furthermore, during the design phase we took a look at the DataUtilities.calculateColumnTotal and Range.contains class to manually develop data flow coverage. Lastly we showcase the DU-pairs per variable, showing the coverage from the previous assignments test cases.

# 2 Manual data-flow coverage calculations for X and Y methods
Method 1: DataUtilities.calculateColumnTotal
Data flow graph:


# 3 A detailed description of the testing strategy for the new unit test

Text…

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Text…

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

Text…

# 6 Pros and Cons of coverage tools used and Metrics you report
Using the tool recommended which was EclEmma it was easy to get started with as we already had it installed on Eclipse. However upon use we saw EclEmma does not explicitly show statement and condition coverage which we ended up using method and line coverage instead. Overall it was easy to use and still provided us the tools to see how coverages changed for test cases.

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.
Over these last two assignments, we have been able to take a look a requirement-based (black-box) and coverage-based (white-box) testing. In terms of requirement-based testing, we looked at code documentation where each method had its requirements written out. Based on this we had to write test cases without looking at the actual source code, but rather develop test cases based on the method functionalities listed. Although this method was relatively simple to implement, due to not looking at the actual source code the chance of not covering edge cases is more likely hence a reduction in coverage.

Comparing this to coverage-based testing we can implement full coverage by analyzing the source code. By doing so we can make sure edge cases are covered. However, this method is more challenging and requires a deeper understanding of how the code functions. After using both methods we were able to see the advantages and disadvantages that come with each method of test generation.

# 8 A discussion on how the team work/effort was divided and managed
Compared to previous assignments we decided to split this one in a way everyone works over the same thing. For 3.2 we all worked together to create the data flow graphs and the respective tables. Furthermore, for the testing portion we all worked together to measure coverages and improve test cases. Using this method we were all able to work on everything and gain knowledge from each section. Furthermore, if we encountered any problems being able to collectivly brainstorm was very effective in solving any issuues.

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab
During the time we were doing section 3.2 it was hard to understand how to obtain the def-use sets. However after coming together and some more research we were able to get it done. This lab allowed us the learn the concepts of white-box testing to imporove test case coverages and implement what we learned in the lectures to create data flow diagrams and DU-pairs.

# 10 Comments/feedback on the lab itself
As the start navigating through the lab was pretty hard and somehwat confusing. Since it was divided into different sections of what needed to be done, we had a hard time understanding at first. However, after coming together and carfully reviewing each step it became easier to navigate.
