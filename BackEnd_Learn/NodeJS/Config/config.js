const dotenv = require('dotenv')
const path = require('path')


dotenv.config({
  path: path.join(__dirname, "..", ".env")
})



module.exports = {
  host: process.env.MYSQL_HOST,
  username: process.env.MYSQL_USERNAME,
  password: process.env.MYSQL_PASS,
  port: process.env.MYSQL_PORT,
  database: process.env.MYSQL_DATABASE,
  dialect: 'mysql'
}
