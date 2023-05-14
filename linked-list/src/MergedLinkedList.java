public class MergedLinkedList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);

        list1.next = node1;
        node1.next = node2;

        ListNode list2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        list2.next = node3;
        node3.next = node4;

        MergedLinkedList mergedLinkedList = new MergedLinkedList();
        ListNode result = mergedLinkedList.merge(list1, list2);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode merge(ListNode list1, ListNode list2) {

        if (list1 == null && list2 != null) {
            return list2;
        }

        if (list1 != null && list2 == null) {
            return list1;
        }

        ListNode result = null;
        ListNode previousNode = null;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                ListNode newNode = new ListNode(list1.val);
                if (result == null) {
                    previousNode = newNode;
                    result = previousNode;
                } else {
                    previousNode.next = newNode;
                    previousNode = newNode;
                }

                list1 = list1.next;
            } else {
                ListNode newNode = new ListNode(list2.val);
                if (result == null) {
                    previousNode = newNode;
                    result = previousNode;
                } else {
                    previousNode.next = newNode;
                    previousNode = newNode;
                }

                list2 = list2.next;
            }
        }

        if (list1 != null) {
            previousNode.next = list1;
        }

        if (list2 != null) {
            previousNode.next = list2;
        }

        return result;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            val = data;
        }
    }
}
