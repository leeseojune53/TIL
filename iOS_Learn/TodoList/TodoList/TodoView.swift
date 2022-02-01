//
//  CheckBox.swift
//  TodoList
//
//  Created by 이서준 on 2022/01/19.
//

import SwiftUI

struct TodoView: View, Identifiable {
    let id: UUID = UUID()
    @State var checked = false
    @State var todoString: String
    var body: some View {
        Button (action: {
            checked = true
        }) {
            HStack {
                Image(systemName: checked ? "checkmark.square.fill" : "square")
                    .foregroundColor(checked ? Color(UIColor.systemBlue) : Color.secondary)
                    .onTapGesture {
                        self.checked.toggle()
                    }
                Text(todoString)
                    .strikethrough(checked)
                    .onTapGesture {
                        self.checked.toggle()
                    }
                Image(systemName: "trash")
                    .onTapGesture {
                        ContentView.deleteElement(uuid: self.id)
                    }
            }
        }
        
        
    }
}

struct CheckBox_Previews: PreviewProvider {
    static var previews: some View {
        TodoView(todoString: "preview")
    }
}
