var createError = require('http-errors');
var express = require('express');
var path = require('path');
const router = express.Router();
var cookieParser = require('cookie-parser');
var logger = require('morgan');
const fileUpload = require('express-fileupload');
const bodyParser = require('body-parser');
const axios = require('axios');
const cors = require('cors');
const qs = require('querystring')


var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

app.use(logger('dev'));
app.use(express.json());
app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());
app.use(express.static(path.join(__dirname, 'public')));
app.use(cors());
app.use(bodyParser.json({limit: '50mb', type: 'application/json'}));

app.use(fileUpload());

app.listen(3000, () => {
    console.log('Runned')
});

app.get('/', (req, res) => {
    res.sendStatus(200)
});

app.post('/upload', async (req, res) => {

    try {

        if (!req.files || Object.keys(req.files).length === 0) {
            return res.status(400).send('No files were uploaded.');
        }
        console.log(req.body)
        let sampleFile = req.files.image;

        await sampleFile.mv(`../CarRentalProject/web/assets/img/${sampleFile.name}`, function (err) {
            if (err)
                return res.status(500).send(err);
        })

        const data = {

            idCarModel: req.body.idCarModel,
            vehiclePower: req.body.vehiclePower,
            vehicleMileage: req.body.vehicleMileage,
            vehicleReg: req.body.vehicleReg,
            vehiclePrice: req.body.vehiclePrice,
            image: `http://localhost:8080/home/assets/img/${sampleFile.name}`
        }

        const config = {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }
        await axios.post('http://localhost:8080/home/vehicle', qs.stringify(data), config);
        res.redirect('http://localhost:8080/home/pages/admin.jsp')

    } catch {
        res.redirect('http://localhost:8080/home/pages/err.jsp')
    }
});


module.exports = router;
module.exports = app;
