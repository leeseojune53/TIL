package models

import "time"

type Task struct {
	ID uint `json:"id" gorm:"primary_key"`
	AssignedTo string `json:"assignedTO"`
	Task string `json:"task"`
	DeadTime time.Time `json:"deadline"`
	CreatedAt time.Time `gorm:"default:CURRENT_TIMESTAMP" json:"created_at"`
	UpdatedAt time.Time `gorm:"default:CURRENT_TIMESTAMP" json:"updated_at"`
}
