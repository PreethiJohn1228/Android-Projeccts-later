import cv2
 
# Opens the Video file
cap= cv2.VideoCapture('test_sequence_439.mov')
i=0
while(cap.isOpened()):
    ret, frame = cap.read()
    if ret == False:
        break
    cv2.imwrite('2Attack'+str(i)+'.jpg',frame)
    i+=1
 
cap.release()
cv2.destroyAllWindows()