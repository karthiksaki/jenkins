module "ec2_instance"{
source  = "terraform-aws-modules/ec2-instance/aws"
count = 3 
ami               = data.aws_ami.amzlinux.id # Replace with your desired AMI ID
key_name = "dallas"
availability_zone = element(["us-west-1a", "us-west-1b", "us-west-1c"], count.index)
tags = {
     Name = "Instance-${count.index}"

}

}
