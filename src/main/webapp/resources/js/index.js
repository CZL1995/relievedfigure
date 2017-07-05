//初始化尺子
//国内流量
var measureRuler = new MeasureRuler({
    wrapperId: "flowW",
    max: 14400,
    minUnit: 10,
    unitSet: 10,
    mult: 1,
    value: 0,
    callback: setFlow
});

function setFlow(val, dparam, limitLeft) {
    if (val >= 14400) {
        $('#flow').val('14400');
        $("#" + dparam.wrapperId + " .rulerScroller").css("left", limitLeft - (14400 / dparam.minUnit) * 10 * dparam.mult);
    } else {
        $('#flow').val(val);
    }
    ;
    $('#flow').focus(function () {
        $(this).val('');
    });
    $('#flow').blur(function () {
        $(this).val($(this).val());
    });
    $('#flow').unbind('input propertychange').bind('input propertychange', function () {
        var val = $(this).val();
        if (val >= 14400 || isNaN(val)) {
            val = 14400;
            $(this).val(val);
        } else {
            val = val;
        }
        ;
        $("#" + dparam.wrapperId + " .rulerScroller").css("left", limitLeft - (val / dparam.minUnit) * 10 * dparam.mult);
    });
};
//语音时长
var measureRuler = new MeasureRuler({
    wrapperId: "voiceW",
    max: 15360,
    minUnit: 5,
    unitSet: 10,
    mult: 1,
    value: 0,
    callback: setVoice
});

function setVoice(val, dparam, limitLeft) {
    if (val >= 15360) {
        $('#voice').val(15360);
        $("#" + dparam.wrapperId + " .rulerScroller").css("left", limitLeft - (15360 / dparam.minUnit) * 10 * dparam.mult);
    } else {
        $('#voice').val(val)
    }
    $('#voice').focus(function (e) {
        e.stopPropagation();
        $(this).val('');
    });
    $('#voice').blur(function () {
        $(this).val($(this).val());
    });
    $('#voice').unbind('input propertychange').bind('input propertychange', function () {
        var val = $(this).val();
        if (val >= 15360 || isNaN(val)) {
            val = 15360;
            $(this).val(val);
        } else {
            val = val;
        }
        ;
        $("#" + dparam.wrapperId + " .rulerScroller").css("left", limitLeft - (val / dparam.minUnit) * 10 * dparam.mult);
    });
}

/*data1 = [{
 //套餐描述
 txt: '4G自选套餐流量包108元档+安心包',
 //套餐费用
 cost: '216',
 }, {
 txt: '4G自选套餐流量包108元档+安心包',
 cost: '216',
 }, {
 txt: '4G自选套餐流量包108元档+安心包',
 cost: '216',
 }]*/
/*var data2 = [{
 flow: '4096', //套餐内流量
 flowCost: '0.29', //超出流量价格
 callTime: '220', //套餐内通话时长
 localCall: '0.19', //本地主叫价格
 feeCost: '178', //月功能费累计
 }, {
 flow: '4096',
 flowCost: '0.29',
 callTime: '220',
 localCall: '0.19',
 feeCost: '178',
 }, {
 flow: '4096',
 flowCost: '0.29',
 callTime: '220',
 localCall: '0.19',
 feeCost: '178',
 }]*/
$('.recommend').click(function () {
    $('.link-table').remove();
    $('.like-table').remove();
    $('.one-p').hide();
    $('.tab-con .box').show();
    var civilFlow = $("#flow").val();
    var voiceTime = $("#voice").val();
    $.ajax({
        url: "/relievedfigure/proc/testproc",
        data: {"civilFlow": civilFlow, "voiceTime": voiceTime},
        type: "POST",
        success: function (data) {
            var index = $('.tab-header .active').parent('li').index();
            if (index == 0) {
                recommendF('#recommendF', data.data1);
                likeTable('#linkTable', data.data2);
            } else {
                recommendF('#recommendF1', data.data3);
                likeTable('#linkTable1', data.data4);
            }

        },
    });


})
//生成推荐套餐
function recommendF(id, data) {
    var bigNum = ['一', '二', '三'];
    var txt = '';
    for (var i = 0; i < data.length; i++) {
        txt = '<div class="link-table">' +
            '<div>' +
            '<p>推荐' + bigNum[i] + '</p>' +
            '</div>' +
            '<div>' +
            '<div>' +
            '<p>' + data[i].txt.one + '</p>' +
            '<p>' + data[i].txt.two + '</p>' +
            '<p>' + data[i].txt.three + '</p>' +
            '</div>' +
            '</div>' +
            '<div>' +
            '<p>' + data[i].cost.one + '</p>' +
            '<p>' + data[i].cost.two + '</p>' +
            '</div>' +
            '</div>';
        $(id).append(txt);
    }
};
//生成推荐套餐对比
function likeTable(id, data) {
    txt = '<div class="like-table">' +
        '<div class="like-tr like-th">' +
        '<div>推荐套餐一</div>' +
        '<div>推荐套餐二 </div>' +
        '<div>推荐套餐三</div>' +
        '</div>' +
        '<div class="like-td">' +
        '<p>套餐内流量</p>' +
        '<div class="like-tr">' +
        '<div>' + data[0].flow + '</div>' +
        '<div>' + data[1].flow + '</div>' +
        '<div>' + data[2].flow + '</div>' +
        '</div>' +
        '</div>' +
        '<div class="like-td">' +
        '<p>超出流量价格</p>' +
        '<div class="like-tr">' +
        '<div>' + data[0].flowCost + '</div>' +
        '<div>' + data[1].flowCost + '</div>' +
        '<div>' + data[2].flowCost + '</div>' +
        '</div>' +
        '</div>' +
        '<div class="like-td">' +
        '<p>套餐内通话时长</p>' +
        '<div class="like-tr">' +
        '<div>' + data[0].callTime + '</div>' +
        '<div>' + data[1].callTime + '</div>' +
        '<div>' + data[2].callTime + '</div>' +
        '</div>' +
        '</div>' +
        '<div class="like-td">' +
        '<p>本地主叫价格</p>' +
        '<div class="like-tr">' +
        '<div>' + data[0].localCall + '</div>' +
        '<div>' + data[1].localCall + '</div>' +
        '<div>' + data[2].localCall + '</div>' +
        '</div>' +
        '</div>' +
        '<div class="like-td">' +
        '<p>月功能费累计</p>' +
        '<div class="like-tr">' +
        '<div>' + data[0].feeCost + '</div>' +
        '<div>' + data[1].feeCost + '</div>' +
        '<div>' + data[2].feeCost + '</div>' +
        '</div>' +
        '</div>' +
        '</div>';
    $(id).append(txt);
}
//底部tab切换
$('.tab-header > li').click(function () {
    var index = $(this).index();
    $('.like-table').remove();
    $('.link-table').remove();
    $('.tab-con > div').hide();
    $('.tab-header p').removeClass('active');
    $(this).find('p').addClass('active');
    $('.tab-con > div').eq($(this).index()).show();

    var civilFlow = $("#flow").val();
    var voiceTime = $("#voice").val();
    $.ajax({
        url: "/relievedfigure/proc/testproc",
        data: {"civilFlow": civilFlow, "voiceTime": voiceTime},
        type: "POST",
        success: function (data) {
           // var index = $('.tab-header .active').parent('li').index();
            if (index == 0) {
                recommendF('#recommendF', data.data1);
                likeTable('#linkTable', data.data2);
            } else {
                recommendF('#recommendF1', data.data3);
                likeTable('#linkTable1', data.data4);
            }

        },
    });



})
