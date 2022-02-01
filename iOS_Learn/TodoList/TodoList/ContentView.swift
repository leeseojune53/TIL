//
//  ContentView.swift
//  TodoList
//
//  Created by 이서준 on 2022/01/14.
//

import SwiftUI

struct ContentView: View {
    @State private var showingAlert = true
    @State var todoValue = ""
    static var todoList : Array<TodoView> = []
    
    var body: some View {
        
        VStack {
            TextField("Enter Your todo.", text: $todoValue)
                .multilineTextAlignment(.center)
            
            HStack {
                Button {
                    ContentView.todoList.removeAll()
                } label: {
                    Text("전체 삭제")
                }
                .padding()
                Button {
                    ContentView.todoList.append(TodoView    (todoString: todoValue))
                    todoValue = ""
                } label: {
                    Text("추가")
                }
                .padding()
            }
            
            Text("\(ContentView.todoList.count)")
            
            
            ScrollView {
                ForEach(ContentView.todoList) {
                    todo in
                    todo
                }
                
                .frame(maxWidth: .infinity)
            }
        }
        
        
    }
    
    static func deleteElement(uuid: UUID) {
        todoList.removeAll(where: { $0.id == uuid })
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
