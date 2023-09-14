# INSERT INTO chat_messages (content, sender_name, time, user_id, chat_room_id)
# SELECT
        #     CONCAT('메세지 내용 ', FLOOR(RAND() * 100)), -- 랜덤한 내용 생성
            #     CONCAT('보낸이 ', FLOOR(RAND() * 22) + 1), -- 랜덤한 사용자 ID 생성 (1~22)
            #     NOW() - INTERVAL 30 DAY + INTERVAL (seq.seq + 1) MINUTE, -- 1분 간격으로 시간 생성
#     FLOOR(RAND() * 22) + 1, -- 랜덤한 사용자 ID 생성 (1~22)
#     FLOOR(RAND() * 16) + 1 -- 랜덤한 채팅방 ID 생성 (1~16)
# FROM information_schema.TABLES,
        #      (SELECT a.seq + b.seq AS seq
        #       FROM (SELECT 0 AS seq UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) a,
        #            (SELECT 0 AS seq UNION SELECT 10 UNION SELECT 20 UNION SELECT 30 UNION SELECT 40) b
        #      ) seq
        # WHERE seq.seq BETWEEN 1 AND 100 -- 100개의 데이터 생성
        # ORDER BY seq.seq;