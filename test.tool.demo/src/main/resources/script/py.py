print("sdfsdf")
# 获取图片特征
from extract_cnn_vgg16_keras import VGGNet
model = VGGNet()
file_path = "./files/zki611nmFGAAqpTAAvqHw7LRwM947.jpg"
queryVec = model.extract_feat(file_path)
feature = queryVec.tolist()
print(feature)