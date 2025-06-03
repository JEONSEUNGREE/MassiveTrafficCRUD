import json

from locust import HttpUser, task, between
import random


class BoardServer(HttpUser):
    wait_time = between(0.1, 0.5)

    def on_start(self):
        self.client.post("/users/sign-in", json={"userId": "test",
                                                 "password": "test1"})

    @task(3)
    def view_item(self):
        sortStatus = random.choice(["CATEGORIES", "NEWEST", "OLDEST", "HIGHPRICE", "LOWPRICE", "GRADE"])
        categoryId = random.randint(1, 10)
        name = '테스트 게시글'.join(str(random.randint(1, 10000)))
        headers = {'Content-Type': 'application/json'}
        data = {"sortStatus": sortStatus,
                "categoryId": categoryId,
                "name": name}
        # print(data)
        self.client.post("/search", json=data, headers=headers)