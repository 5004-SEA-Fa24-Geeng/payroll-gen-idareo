# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for?

    "comma-seperated values"

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?

    This allows you to use the interface which will create more flexibility when writing the code. it can be used with both hourly and salaried employees
    You can also swap between using a LinkedList or ArrayList without the rest of the code being affected.

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?

    This would be a has-a relationship.

4. Can you provide an example of a has-a relationship in your code (if one exists)?

    **FILL IN**


5. Can you provide an example of an is-a relationship in your code (if one exists)?

   **FILL IN**

6. What is the difference between an interface and an abstract class?
    
    There are multiple differences between an interface and an abstract class but I think the major ones are:
            1. Classes have clearly defined methods, whereas interfaces do not.
            2. Within the class to implements the interface or extends the Abstract shape, you can implement multiple interfaces but only have one abstract class
            3. All methods must be overriden with interfaces while with an abstract class, you can either use it or override the methods.
            4. An interface can only have public methods, while an abstract class can have a mix of public, private and protected.
            5. Interfaces implement a 'can-also-do' relationship while the abstract class implements an 'is-a-kind-of'

7. What is the advantage of using an interface over an abstract class?

    When there ara common attributes amongst multiple classes and the behavior needs to be different for each 

8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 

    The code is not valid because primitive types to not work with collection objects. It will need to be updated to use the wrapper class 'Integer' (List<Integer> numbers = new ArrayList<Integer>).
    A wrapper object can then be created by calling the wrapper class.

9. Which class/method is described as the "driver" for your application? 

        PayrollGenerator.Java

10. How do you create a temporary folder for JUnit Testing? 

    @Test
    void testWithTempFiles(@TempDir Path tempDir)
    Path file = tempDir.resolve("temp_file.txt");
    ...
    }
    


## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 
