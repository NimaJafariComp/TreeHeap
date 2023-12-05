# TreeHeap Implementation

This Java program demonstrates the implementation of a TreeHeap using the MaxHeap approach. The TreeHeap is a binary heap that follows the MaxHeap property, where the value of each node is greater than or equal to the values of its children.

## Features

- **Insertion**: Insert a new key into the TreeHeap while maintaining the MaxHeap property.
- **Removal**: Remove the root node (maximum value) from the TreeHeap while preserving the MaxHeap property.
- **Display**: Visualize the TreeHeap structure using a pre-order traversal with proper formatting.

## Usage

1. **Initialize TreeHeap**: Create an instance of the `MaxHeap` class.

2. **Insert Nodes**: Use the `insert(int key)` method to add nodes to the TreeHeap.

3. **Remove Root**: Utilize the `remove()` method to remove the root (maximum value) from the TreeHeap.

4. **Display TreeHeap**: View the structure of the TreeHeap using the `displayHeap()` method.

## Sample Code

```java
public class TreeHeapMain {

    public static void main(String[] args) {
        MaxHeap treeHeap = new MaxHeap();

        // Insert nodes
        treeHeap.insert(50);
        treeHeap.insert(30);
        treeHeap.insert(80);
        treeHeap.insert(20);
        treeHeap.insert(40);
        treeHeap.insert(60);
        treeHeap.insert(90);

        // Display the TreeHeap
        System.out.println("TreeHeap Structure:");
        treeHeap.displayHeap();

        // Remove the root node
        treeHeap.remove();
        System.out.println("\nTreeHeap after removing the root:");
        treeHeap.displayHeap();
    }
}
```

## Class Structure

- `MaxHeap`: Main class representing the TreeHeap.
  - `Node`: Inner class representing a node in the TreeHeap.

## Display Format

The TreeHeap is displayed in a tree-like structure with proper indentation. The left child is denoted by `|--`, and the right child is denoted by `---`. The structure is visualized using a pre-order traversal.

## Contributing

Feel free to contribute by forking the repository, making changes, and submitting a pull request. Your feedback and improvements are welcome!

## License

This project is licensed under the [MIT License](LICENSE). Use it, modify it, and share it as needed.
