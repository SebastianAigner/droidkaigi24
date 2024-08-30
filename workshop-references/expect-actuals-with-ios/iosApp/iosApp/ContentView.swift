import SwiftUI
import Shared

struct ContentView: View {
    @State private var showContent = false
    @State private var showAlert = true
    @State private var typedText = ""
    @State private var restoredText = ""
    var body: some View {
        VStack(spacing: 30) {
            TextField("Type something...", text: $typedText)
                .textFieldStyle(RoundedBorderTextFieldStyle())
                .padding()
            Button("Store some text!") {
                StorageKt.saveString(key: "my-key", value: typedText)
                withAnimation {
                    showContent = !showContent
                }
            }

            Button("Restore some text!") {
                let restored = StorageKt.loadString(key: "my-key")
                restoredText = restored
            }

            Text("Restored text: \(restoredText)")
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
