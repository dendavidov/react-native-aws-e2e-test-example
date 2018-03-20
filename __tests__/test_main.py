def test_basic(driver):
    WAIT_SEC = 10
    driver.implicitly_wait(WAIT_SEC)

    elem = driver.find_element_by_accessibility_id('testview')

    assert elem is not None


def test_button(driver):
    WAIT_SEC = 10
    driver.implicitly_wait(WAIT_SEC)

    btn = driver.find_element_by_accessibility_id('button')
    btn.click()

    name = driver.find_element_by_accessibility_id('name')
    assert name.text == 'Leanne Graham'

    identifierInput = driver.find_element_by_accessibility_id('text')
    identifierInput.clear()
    identifierInput.send_keys('2')
    btn.click()
    assert name.text == 'Ervin Howell'
