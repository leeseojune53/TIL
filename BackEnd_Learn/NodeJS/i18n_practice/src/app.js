const express = require('express');
const i18next = require('i18next');
const Backend = require('i18next-node-fs-backend');
const i18nextMiddleware = require('i18next-express-middleware');
const req = require('express/lib/request');

i18next
    .use(Backend)
    .use(i18nextMiddleware.LanguageDetector)
    .init({
        backend: {
            loadPath: __dirname + '/../locales/{{lng}}/{{ns}}.json'
        },
        fallbackLng: 'en',
        preload: ['en', 'es']
    });

const app = express();

const instances = {};

app.use(i18nextMiddleware.handle(i18next));

app.get('/greeting', (req, res) => {
    // const response = req.t('greeting');
    let instance = instances[req.language];
    if (instance == null) {
      instance = instances[req.language] = req.t;
    }
    const response = instance('greeting');

    i18next.changeLanguage('en')

    const secondResponse = instance('greeting')

    i18next.changeLanguage('ko')

    const thirdResponse = instance('greeting')

    test()

    res.status(200);
    res.send(response + ' ' + secondResponse + ' ' + thirdResponse + req.t('greeting'));
});

function test() {
  console.log(req.t)
}

app.listen(8080, () => console.log('Example app listening on port 8080!'));