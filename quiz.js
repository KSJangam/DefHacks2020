var questionsArr = ["What should you do if you learn someone you had recent interaction with tested positive for COVID-19?",
    "What is an appropriate distance to keep for social distancing?",
    "Who is most at risk from the following options?",
    "Which of the following is false?",
    "Which of the following is a safe activity?",
    "Which of the following are true?"];

var oneArr = ["Isolate for 14 days", "Arms length", "Asthma patients", "Coughing is a potential symptom",
    "Going to a party", "COVID-19 should be taken lightly"];

var twoArr = ["Go to a friend's house", "16 inches", "Senior citizens", "Antibiotics counter COVID-19",
    "Inviting long-distance guests over", "COVID-19 is like the flu"];

var threeArr = ["Throw a party", "6 inches", "Immuno-compromised patients", "The virus can lead to death",
    "Baking banana bread at home", "COVID-19 can linger on surfaces"];

var fourArr = ["Resume life as normal", "6 feet", "All of the above", "The elderly are at risk",
    "Going to the movies with no mask", "COVID-19 is not a virus"];

var ansArr = [1, 4, 4, 2, 3, 3];

var grade = 0;
const maxGrade = 7;

var ind = 0;
var clickStr;
var userAns = 0;

starting1 = true;
starting2 = true;

function firstQ() {

}

// function firstQ() {
//     $("hid-panel").removeClass("start-quiz");
// }
$(".btn").click(function (event) {
    var clickStr = $(this).attr("id");
    switch (clickStr) {
        case "first":
            userAns = 1;
            break;
        case "second":
            userAns = 2;
            break;
        case "third":
            userAns = 3;
            break;
        case "fourth":
            userAns = 4;
            break;
        default:
            break;
    }

    if (starting1) {
        starting1 = false;
        begin();
    } else if (starting2) {
        otherAns();
    } else {
        $("#question").html("Game Over, Score: " + grade + "/7 Correct! Refresh to restart");

    }



})

function begin() {
    if (userAns == 2) {
        grade++;
    } else {
        $("#question").html("Wrong!");
    }
    $("#second").removeClass("btn-outline-light");
    $("#second").addClass("btn-success");
    setTimeout(function () {
        $("#second").removeClass("btn-success");
        $("#second").addClass("btn-outline-light");
        otherQues();
    }, 1500);
}

function otherQues() {
    if (ansArr.length != 0) {

        ind = Math.floor(Math.random() * (ansArr.length));

        $("#question").html(questionsArr[ind]);
        $("#first").html(oneArr[ind]);
        $("#second").html(twoArr[ind]);
        $("#third").html(threeArr[ind]);
        $("#fourth").html(fourArr[ind]);


    } else {
        starting2 = false;
    }

}

function otherAns() {

    var ansC = ansArr[ind];
    correctStr = "";

    switch (ansC) {
        case 1:
            correctStr = "first";
            break;
        case 2:
            correctStr = "second";
            break;
        case 3:
            correctStr = "third";
            break;
        case 4:
            correctStr = "fourth";
            break;
        default:
            break;
    }

    if (userAns == ansArr[ind]) {
        grade++;
    } else {
        $("#question").html("Wrong!");
    }
    $("#" + correctStr).removeClass("btn-outline-light");
    $("#" + correctStr).addClass("btn-success");
    setTimeout(function () {
        $("#" + correctStr).removeClass("btn-success");
        $("#" + correctStr).addClass("btn-outline-light");

        questionsArr.splice(ind, 1);
        oneArr.splice(ind, 1);
        twoArr.splice(ind, 1);
        threeArr.splice(ind, 1);
        fourArr.splice(ind, 1);
        ansArr.splice(ind, 1);

        if (ansArr.length == 0) {
            $("#question").html("Game Over, Score: " + grade + "/7 Correct! Refresh to restart");
        }

        otherQues();
    }, 3000);


}


