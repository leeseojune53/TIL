import * as dotenv from 'dotenv'

dotenv.config()

export const JWT_SECRET = process.env.PRODUCTION_JWT_SECRET;

export const JWT_ACCESS_EXP = process.env.PRODUCTION_ACCESS_EXP;

export const JWT_REFRESH_EXP = process.env.PRODUCTION_REFRESH_EXP;