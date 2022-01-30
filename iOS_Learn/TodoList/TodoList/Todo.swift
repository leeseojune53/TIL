//
//  CheckBox.swift
//  TodoList
//
//  Created by 이서준 on 2022/01/19.
//

import SwiftUI

struct Todo: View {
    @State var checked = false;
    @State var todoString = "asdff";
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
            }
        }
        
        
    }
}

struct CheckBox_Previews: PreviewProvider {
    static var previews: some View {
        Todo()
    }
}
