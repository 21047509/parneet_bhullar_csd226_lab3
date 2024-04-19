// Function to send data to backend to update
async function updateData() {
    try {
        const newData = document.getElementById('newDataInput').value; // Get user input
        const response = await fetch('/string-value', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ newData }) // Send user input in JSON format
        });
        // Optionally handle response
    } catch (error) {
        console.error('Error updating data:', error);
    }
}