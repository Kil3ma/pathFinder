class GridService {

    createGrid() {
        const width = document.getElementById('width').value;
        const height = document.getElementById('height').value;
        return fetch('http://localhost:8080/pathfinder/grid', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ width, height }),
        })
            .then(response => response.json())
            .then(data => {
                currentGrid = data;
                displayGrid(data);
            })
            .catch(error => console.error('Error:', error));
    }

    clearPath() {
        return fetch('http://localhost:8080/pathfinder/grid-setup/clear', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ grid: currentGrid }),
        })
            .then(response => response.json())
            .then(data => {
                currentGrid = data;
                displayGrid(data);
            })
            .catch(error => console.error('Error:', error));
    }

}