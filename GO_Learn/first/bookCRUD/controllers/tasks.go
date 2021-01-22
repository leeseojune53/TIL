package controllers

import (
	"first/bookCRUD"
	"github.com/gin-gonic/gin"
	"net/http"
	"time"
)

type CreateTaskInput struct {
	AssignedTo string `json:"assignedTo"`
	Task string `json:"task"`
	Deadline string `json:"deadline"`
}

type UpdateTaskInput struct{
	AssignedTo string `json:"assignedTo"`
	Task string `json:"task"`
	Deadline string `json:"deadline"`
}

func CreateTask(c *gin.Context)  {
	var input CreateTaskInput
	if err := c.ShouldBindJSON(&input); err != nil{
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}
	date := "2021-01-22"
	deadline, _ := time.Parse(date, input.Deadline)

	task := models.Task()


}