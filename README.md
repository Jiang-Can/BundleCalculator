#Bundle Calculator

## Context
One company has decided to allow social media influencers 
to sell posts in bundles and charge the brand on a per bundle basis. 
It needs to design the project to be able to sell with the smallest number of bundles in each order.

## Design ideas
The project designed three major components, namely CalculatorCore, InputHandler and OutputHandler.

InputHandler is responsible for reading the order information in the input.txt file under the resource file, 
as well as reading the different submission formats provided in the bundles.json file, 
and converting them into fixed formats for use by CalculatorCore and OutputHandler.

CalculatorCore receives bundles array and corresponding total required number, 
Then calling the processData method to generate combination of bundle which contain the minimal number of bundles

OutputHandler buildOutputStr method receives processed bundle combination List from CalculatorCore 
and corresponding Format object to build output string. Lastly, call the outputResult method to output
result on console

### InputHandler
It uses two HashMap to store the required submission format(order information) from input.txt and  
company provided bundle choose(submission formats) from bundles.json file separately. Since they are
multiple type of format, both HashMap use format code as key to match the input and corresponding format object.
### CalculatorCore
Adopting greedy algorithm to  give priority to match the larger bundle, in this case, it can promise that the 
minimal number of bundle combination which satisfied total required number could be found firstly. After found,
the process terminate. Cache is involved to solve the repeated recursion problem. However, there is a bad situation that
bundles choices provided by the company may not exactly match the number of total, so I design a second algorithm to match
the most the biggest bundle as much as possible also with the minimal overage.
### OutputHandler
Since it may contain multiple kinds of submission format in order, so I design to iteratively assemble the every kind of submission format output string 
in a StringBuilder, and output eventually. 

## User manual

###Configuration of bundles specs

Company can config the bundles specs in json style 
(including submission format`name`, format code`code`,bundles`bundles` with map provided number`key`,corresponding price`value`)

Example in json
```
[
    {
    "name":"submission format" ,
    "code":"format code",
    "bundles":{"key":"value","key":"value"}
    }
]
```
Example of bundles specs configuration(multiple)
```
[
    {
    "name":"image" ,
    "code":"IMG",
    "bundles":{"5":"450","10":"800"}
    },
    {
    "name":"audio" ,
    "code":"FLAC",
    "bundles":{"3":"427.5","6":"810","9":"1147.5"}
    }
]
```

###Input order

Input the order in the format that `required number`+" "+`format code`
in the file `input.txt` under resources directory.

Example of Input
```
10 IMG
15 FLAC
13 VID
```
###Boot the calculator

Only need to new an instance of Calculator Runner and call the runCalculator() method

Example
```
public class Boot {
    public static void main(String[] args) {
        new CalculatorRunner().runCalculator();
    }
}
```


