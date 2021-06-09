# treasure-hunt

Supports board size of 5 * 5.

You have to provide the 2D array for a treasure. The values in the array are clues. Each cell contains
an integer between 11 and 55, for each value the tens digit represents the row number and the unit digit represents 
the column number of the cell containing the next clue.

This application is built on rest services using spring boot and runs on localhost:8080 and can be deployed as container-less

### How to run this locally
Build the project using `mvn clean install`

This would run build and create the jar in `target` folder

Execute the cmd `java -jar treasurehunt-0.0.1-SNAPSHOT.jar`

Application will be up on localhost: 8080
 


###API

To populate the treasure map data using post request. And provide the body as per below format.

POST : http://localhost:8080/treasure-hunt
```json
{
	"treasureBoard": [
		[{
			"row": 1,
			"col": 1,
			"val": 34
		}, {
			"row": 1,
			"col": 2,
			"val": 21
		}, {
			"row": 1,
			"col": 3,
			"val": 32
		}, {
			"row": 1,
			"col": 4,
			"val": 41
		}, {
			"row": 1,
			"col": 5,
			"val": 25
		}],
		[{
			"row": 2,
			"col": 1,
			"val": 14
		}, {
			"row": 2,
			"col": 2,
			"val": 42
		}, {
			"row": 2,
			"col": 3,
			"val": 43
		}, {
			"row": 2,
			"col": 4,
			"val": 14
		}, {
			"row": 2,
			"col": 5,
			"val": 31
		}],
		[{
			"row": 3,
			"col": 1,
			"val": 54
		}, {
			"row": 3,
			"col": 2,
			"val": 45
		}, {
			"row": 3,
			"col": 3,
			"val": 52
		}, {
			"row": 3,
			"col": 4,
			"val": 42
		}, {
			"row": 3,
			"col": 5,
			"val": 23
		}],
		[{
			"row": 4,
			"col": 1,
			"val": 33
		}, {
			"row": 4,
			"col": 2,
			"val": 15
		}, {
			"row": 4,
			"col": 3,
			"val": 51
		}, {
			"row": 4,
			"col": 4,
			"val": 31
		}, {
			"row": 4,
			"col": 5,
			"val": 35
		}],
		[{
			"row": 5,
			"col": 1,
			"val": 21
		}, {
			"row": 5,
			"col": 2,
			"val": 52
		}, {
			"row": 5,
			"col": 3,
			"val": 33
		}, {
			"row": 5,
			"col": 4,
			"val": 13
		}, {
			"row": 5,
			"col": 5,
			"val": 23
		}]
	]
}
```

GET Request : http://localhost:8080/treasure-hunt/path
If treasure found in the given treasure-map.
```json
{
    "message": "Treasure found at spot: {row=5, col=2, val=52}",
    "path": [
        {
            "row": 1,
            "col": 1,
            "val": 34
        },
        {
            "row": 3,
            "col": 4,
            "val": 42
        },
        {
            "row": 4,
            "col": 2,
            "val": 15
        },
        {
            "row": 1,
            "col": 5,
            "val": 25
        },
        {
            "row": 2,
            "col": 5,
            "val": 31
        },
        {
            "row": 3,
            "col": 1,
            "val": 54
        },
        {
            "row": 5,
            "col": 4,
            "val": 13
        },
        {
            "row": 1,
            "col": 3,
            "val": 32
        },
        {
            "row": 3,
            "col": 2,
            "val": 45
        },
        {
            "row": 4,
            "col": 5,
            "val": 35
        },
        {
            "row": 3,
            "col": 5,
            "val": 23
        },
        {
            "row": 2,
            "col": 3,
            "val": 43
        },
        {
            "row": 4,
            "col": 3,
            "val": 51
        },
        {
            "row": 5,
            "col": 1,
            "val": 21
        },
        {
            "row": 2,
            "col": 1,
            "val": 14
        },
        {
            "row": 1,
            "col": 4,
            "val": 41
        },
        {
            "row": 4,
            "col": 1,
            "val": 33
        },
        {
            "row": 3,
            "col": 3,
            "val": 52
        },
        {
            "row": 5,
            "col": 2,
            "val": 52
        }
    ],
    "pathFound": true
}
```
If treasure not found in treasure map:
```json
{
    "message": "No treasure path found",
    "path": null,
    "pathFound": false
}
```


Main Starting Application Class:
[TreasurehuntApplication](treasurehunt/src/main/java/com/game/treasurehunt/TreasurehuntApplication.java)

Treasure path tracker logic is present in below class:
[TreasurePathTracking](treasurehunt/src/main/java/com/game/treasurehunt/calculation/TreasurePathTracking.java)


