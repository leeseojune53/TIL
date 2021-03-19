import path from "path";
import dotenv from "dotenv";

dotenv.config({path: path.join(__dirname, "../.env")})

const databaseConfigList = {
    development: {
        type: "mysql",
        host: process.env.DEVELOPER_HOST,
        
    }
}