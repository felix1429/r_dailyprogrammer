//http://www.reddit.com/r/dailyprogrammer/comments/271xyp/622014_challenge_165_easy_ascii_game_of_life/ci5xwk4
<?php
$file = fopen("D:/PhpstormProjects/Game of Life/input.txt","r");
$firstLine = explode(" ",fgets($file));
$iterations = $firstLine[0];
$x = $firstLine[1];
$limit = $firstLine[2];
$array = array();
for($i = 0;$i < $limit;$i ++) {
    $array[$i] = fgets($file);
}
$copy = $array;
for($i = 1;$i <= $iterations;$i ++) {
    for($j = 0;$j < $limit;$j ++) {
        for($k = 0;$k < $x;$k ++) {
            testCell($j,$k);
        }
    }
    usleep(100000);
    printArray($copy);
    $array = $copy;
}

function testCell($height,$width) {
    global $array,$copy;
    $temp = 0;
    if($array[checkIndex($height - 1,'h')][$width] == '#') { $temp ++; }
    if($array[checkIndex($height - 1,'h')][checkIndex($width + 1,'w')] == '#') { $temp ++; }
    if($array[checkIndex($height - 1,'h')][checkIndex($width - 1,'w')] == '#') { $temp ++; }
    if($array[checkIndex($height + 1,'h')][checkIndex($width - 1,'w')] == '#') { $temp ++; }
    if($array[checkIndex($height + 1,'h')][$width] == '#') { $temp ++; }
    if($array[checkIndex($height + 1,'h')][checkIndex($width + 1,'w')] == '#') { $temp ++; }
    if($array[$height][checkIndex($width + 1,'w')] == '#') { $temp ++; }
    if($array[$height][checkIndex($width - 1,'w')] == '#') { $temp ++; }
    if($array[$height][$width] == '.') {
        if($temp == 3) {
            $copy[$height][$width] = '#';
        }
    }elseif($array[$height][$width] == '#') {
        if(($temp < 2) || ($temp > 3)) {
            $copy[$height][$width] = '.';
        }
    }
}

function checkIndex($var,$let) {
    global $x,$limit;
    $tempIndex = '';
    if($let == 'h') {
        $tempIndex = $limit;
    }elseif($let == 'w') {
        $tempIndex = $x;
    }

    if($var == $tempIndex) {
        return 0;
    }elseif($var == -1) {
        return $tempIndex - 1;
    }else {
        return $var;
    }
}

function printArray($arrayVar) {
    global $x,$limit;
    $tempString = "";
    for($i = 0;$i < $limit;$i ++) {
        for($j = 0;$j < $x;$j ++) {
            $tempString .= $arrayVar[$i][$j];
        }
        $tempString .= "\r\n";
    }
    echo $tempString . "\n\n";
}
?>