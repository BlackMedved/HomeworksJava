#language: ru
@homework19
Функция: Авторизация на the-internet.herokuapp.com

  @success
  Сценарий: Успешный логин с корректными данными
    Дано открыта главная страница the-internet
    Когда открыта страница Form Authentication
    Тогда заголовок страницы содержит "Login Page"
    Когда введен логин "tomsmith" и пароль "SuperSecretPassword!"
    Тогда отображается сообщение "You logged into a secure area!"
    И на экране присутствует кнопка Logout
    Когда нажата кнопка Logout
    Тогда заголовок страницы содержит "Login Page"

  @negative
  Сценарий: Логин с некорректными данными
    Дано открыта главная страница the-internet
    Когда открыта страница Form Authentication
    Тогда заголовок страницы содержит "Login Page"
    И внизу страницы есть ссылка Elemental Selenium
    Когда введен логин "admin" и пароль "1234"
    Тогда отображается сообщение "Your username is invalid!"