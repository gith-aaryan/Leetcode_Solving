class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null){

            // If current node is duplicate
            if(curr.next != null && curr.val == curr.next.val){

               // Move to last duplicate value
                while(curr.next != null && curr.val == curr.next.val){
                   curr =  curr.next; 

                }

               // Remove all duplicate nodes
                prev.next = curr.next;


            } else {

               // Current node is unique , we have found unique node
                prev = prev.next;

            }

            // Move to next node
            curr = curr.next;

        }

        // Return actual head, not dummy node
        return dummy.next;

        
    }
}