package models

import (
	"encoding/json"
	"fmt"
	"github.com/jinzhu/gorm"
	"log"
	"os"
)

type MysqlConfig struct {
	USER string `json:"USER"`
	PASS string `json:"PASS"`
	HOST string `json:"HOST"`
	PORT string `json:"PORT"`
	DBNAME string `json:"DBNAME"`
}

func LoadConfig() (MysqlConfig, error) {
	var config MysqlConfig
	file, err := os.Open("conf.json")
	defer file.Close()
	if err != nil{
		log.Fatal(err)
	}
	decoder := json.NewDecoder(file)
	err = decoder.Decode(&config)
	if err != nil{
		log.Fatal(err)
	}
	return config, err
}

func SetupDB() *gorm.DB {
	config, err := LoadConfig()

	if err != nil{
		log.Fatal(err)
	}

	USER := config.USER
	PASS := config.PASS
	HOST := config.HOST
	PORT := config.PORT
	DBNAME := config.DBNAME
	URL := fmt.Sprintf("%s:%s@tcp(%s:%s)/%s?charset=utf8&parseTime=True&loc=Local", USER, PASS, HOST, PORT, DBNAME)

	db, err := gorm.Open("mysql", URL)

	if err != nil {
		panic(err.Error())
	}
	return db
}