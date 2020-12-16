const dotenv = require('dotenv')
const path = require('path')


dotenv.config({
  path: path.join(__dirname, "..", ".env")
})

if(!process.env.MYSQL_HOST){
}

if(!process.env.MYSQL_USERNAME){
  dotenv.config({
    username: 'root'
  })
}

if(!process.env.MYSQL_PASS){
  dotenv.config({
    password: 'lee@1234'
  })
}

if(!process.env.MYSQL_PORT){
  dotenv.config({
    port: 3306
  })
}

if(!process.env.MYSQL_DATABASE){
  dotenv.config({
    database: 'test'
  })
}

module.exports = {
  host: process.env.MYSQL_HOST,
  username: process.env.MYSQL_USERNAME,
  password: process.env.MYSQL_PASS,
  port: process.env.MYSQL_PORT,
  database: process.env.MYSQL_DATABASE,
  dialect: 'mysql'
}
