Feature: Life of king

In order to go office
As a working guy
I want to wish people

@tester
Scenario Outline:I am a kingman

Given I work in Latenights
When I meet watchmen
Then I Greeted him

Given I work in Mornings
When I meet NewspaperssBoy
Then I skipGreeting him

Given we work in "<weekday>"
When we meet "<guy>"
Then I skipGreeting him

Examples:
 |weekday |   guy     |
 |tenpm   | watchmen  |
 |ninepm  |  cabdriver|