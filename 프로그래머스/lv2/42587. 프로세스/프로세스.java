// 노드
class NodeBi {
  int data;
  NodeBi next;
  NodeBi prev;
  NodeBi(int data, NodeBi next, NodeBi prev) {
    this.data = data;
    this.next = next;
    this.prev = prev;
  }
}

// 원형 연결리스트 구현
class CircularLinkedList {
  NodeBi head;
  NodeBi tail;

  NodeBi target;
  int targetIdx;
  int targetValue;

  int cnt;
  int elemCnt;

  int minOfBigger = 10;
  int max = 0;

  CircularLinkedList(int targetIdx, int targetValue) {
    this.targetIdx = targetIdx;
    this.targetValue = targetValue;
    this.cnt = 1;
  }

  // 데이터 추가
  public void addData(int data, int i) {
    // target 보다 작은 수는 무시
    if (targetValue > data) {
      return;

    // 원형리스트에서 target데이터보다 큰 수를 지울 때 사용할 것이다. (target데이터보다 큰 수의 범위를 구함)
    } else if (targetValue < data) {
      this.minOfBigger = Math.min(data, minOfBigger);
      this.max = Math.max(data, max);
    }

    // 데이터 추가 : 리스트가 비어있는 경우
    if (this.head == null) {
      this.head = new NodeBi(data, null, null);
      this.tail = this.head;
      this.head.prev = this.tail;
      this.tail.next = this.head;
      this.elemCnt++;

    // 맨 뒤에 데이터 추가 -> tail 재정의 작업 해주어야 됨.
    } else {
      this.tail = new NodeBi(data, this.head, this.tail);
      this.head.prev = this.tail;
      this.tail.prev.next = this.tail;
      this.elemCnt++;
    }

    // 만약 target 데이터면 target 노드로 지정한다.
    if (targetIdx == i) target = this.tail;
  }

  // target 데이터와 같은 값을 제외하고 가장 큰 수부터 순서대로 지워준다.
  public void removeData() {
    // 배열에 다 같은 수만 있던 경우 ex [1,1,1,1,1] -> max와 minOfBigger가 초기값과 동일함.
    if ((max == 0) && (minOfBigger == 10)) {
      // 값이 하나라서 남은 노드가 1개로 정해져있음. ex [1]
      if (elemCnt == 1) {
        return;
      }
      // 그렇지 않은 경우 ex [2,1,1,1] -> 원형 리스트에는 [1,1,1]만 있기 때문에 큰 수를 지우는 작업은 필요 없음.
      cntData(this.head);
      return;
    }

    // target 데이터의 값보다 큰 수가 있는 경우
    NodeBi cur = this.head;   // 삭제할 데이터 위치
    NodeBi pre = cur.prev;    // cur 바로 이전에서 따라다니는 노드
    NodeBi point = cur.next;  // 가장 큰 수를 다 지운 후 그 다음 큰 수를 지울 때 시작하는 위치
    NodeBi spot = pre;        // 다시 시작하는 위치의 바로 직전 위치 (한 바퀴의 기준으로, 반복문을 멈출 때 사용)

    for (int i = max; i >= minOfBigger; i--) {
      do {
        if (cur.data == i) {
          // 남은 노드가 두개인 경우 -> if문 없이 진행하면 무한 루프 오류발생 (이 반례를 못찾아서 힘들었음,,)
          if (cur.next == pre) {
            this.cnt++;
            return;
          }
          // 남은 노드가 세개 이상인 경우
          cur.next.prev = pre;
          pre.next = cur.next;
          point = cur.next;
          if (cur == head) this.head = cur.next;
          this.cnt++;
        }
        cur = cur.next;
        pre = cur.prev;
      } while (cur != spot);

      // while문의 조건에 false로 나오게되면 마지막 노드는 확인하지 못하고 종료되기 때문에 따로 작성.
      if (cur.data == i) {
        // 남은 노드가 두개인 경우
        if (cur.next == pre) {
          this.cnt++;
          return;
        }
        // 남은 노드가 세개 이상인 경우
        cur.next.prev = pre;
        pre.next = cur.next;
        point = cur.next;
        this.cnt++;
      }
      cur = point;
      pre = cur.prev;
      spot = pre;
    }
    cntData(point);
  }

  // 큰 수를 다 제거한 후 같은 우선순위를 가지는 노드만 남아있음.
  public void cntData(NodeBi point) {
    // target 이 대기 큐에서 바로 나오는 경우
    if ((point == target) || (elemCnt == 1)) {
      return;
    }

    // target 이 대기 큐에서 바로 나오지 않는 경우
    do {
      this.cnt++;
      point = point.next;
    } while (point != target);
  }
}

class Solution {
  public int solution (int[] priorities, int location) {
    CircularLinkedList list = new CircularLinkedList(location, priorities[location]);

    // 반복문으로 원형리스트에 값을 보냄 (원형리스트 클래스에서 필터링하여 필요한 값만 리스트에 삽입)
    for (int i = 0; i < priorities.length; i++) {
      list.addData(priorities[i], i);
    }
    // target데이터보다 큰 수를 다 지움. (이때 지워진 큰 수의 개수는 cnt++)
    list.removeData();

    return list.cnt;
  }
}