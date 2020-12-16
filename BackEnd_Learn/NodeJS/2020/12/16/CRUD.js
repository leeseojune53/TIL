const mysql = require('mysql')
const db_config = require('../../../Config/DBconfig.json')
const client = mysql.createConnection({
    user: db_config.user,
    password: db_config.password,
    database: db_config.database,
    host: db_config.host,
    port:3306
})

client.connect();

client.query('SELECT * FROM test', function(error, results, fields){
    if(error){
        console.log(error);
    }
    console.log(results);
})

client.end();