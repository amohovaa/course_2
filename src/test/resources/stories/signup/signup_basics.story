Narrative:
This story covers basics tests of signup

Lifecycle:
Before:
Given I open signup page

Scenario: Type invalid values
When I type email "test@mail.test"
When I type confirmation email "wrong@mail.test"
When I type password "qwerty!123"
When I type name "Testname"
Then I see error "Адреса электронной почты не совпадают."

Scenario: Type short password
When I type email "test@mail.test"
When I type confirmation email "test@mail.test"
When I type password "9"
When I type name "Testname"
Then I see error "Пароль слишком короткий."
