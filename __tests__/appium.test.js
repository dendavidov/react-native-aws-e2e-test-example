import wd from 'wd';

jasmine.DEFAULT_TIMEOUT_INTERVAL = 60000;
const PORT = 4723;
const config = {
  platformName: 'Android',
  deviceName: 'Android',
  app: './build/homeapp.android.release.apk', // relative to root of project
};
const driver = wd.promiseChainRemote('localhost', PORT);

beforeAll(async () => {
  await driver.init(config);
  await driver.sleep(2000); // wait for app to load
});

test('appium renders', async () => {
  expect(await driver.hasElementByAccessibilityId('text')).toBe(true);
  const text = await driver.elementByAccessibilityId('text').text();
  expect(text).toBe('1');

  expect(await driver.hasElementByAccessibilityId('button')).toBe(true);
  await driver.elementByAccessibilityId('button').click();

  await driver.sleep(2000);

  let name = await driver.elementByAccessibilityId('name').text();
  expect(name).toBe('Leanne Graham');

  await driver.elementByAccessibilityId('text').clear();
  await driver.elementByAccessibilityId('text').type('2');

  await driver.elementByAccessibilityId('button').click();

  await driver.sleep(2000);
  name = await driver.elementByAccessibilityId('name').text();
  expect(name).toBe('Ervin Howell1');
});
