# SpanableTool
简单的封装了SpannerBuilder
使用简介;
创建一个spannaleTookTextStyle 对象，
设置需要的属性
SpannaleTookTextStyle spannaleTookTextStyle = new SpannaleTookTextStyle();
spannaleTookTextStyle.setCick(true);
spannaleTookTextStyle.setLineType(SpannableTool.LineType.UNDER_LINE);
spannaleTookTextStyle.setChooseString(sonContent);
spannaleTookTextStyle.setLineType(SpannableTool.LineType.DELET_LINE);
spannaleTookTextStyle.setListener(new View.OnClickListener() {
@override
public void onClick(View v) {
Toast.makeText(SpannableTestActivity.this, "点击", Toast.LENGTH_SHORT).show();
}
});

创建第二个spannaleTookTextStyle 对象，（设置多段文字）
SpannaleTookTextStyle spannaleTookTextStyle1 = new SpannaleTookTextStyle();
spannaleTookTextStyle1.setLineType(SpannableTool.LineType.UNDER_LINE);
spannaleTookTextStyle1.setChooseString(addContent);
spannaleTookTextStyle1.setLineType(SpannableTool.LineType.DELET_LINE);

    SpannableTool spannableTool = new SpannableTool.SpannableToolBuilder(mainContent)
// .addOriginalString(addContent)
.setSingleChooseString(spannaleTookTextStyle)
.setSingleChooseString(spannaleTookTextStyle1)
.createSpannableTool();
//添加到TextView中
mTvArea.setText(spannableTool.getSpannaleString());
mTvArea.setMovementMethod(LinkMovementMethod.getInstance()); //可点击
